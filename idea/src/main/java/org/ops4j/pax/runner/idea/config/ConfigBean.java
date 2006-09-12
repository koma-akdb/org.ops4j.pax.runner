package org.ops4j.pax.runner.idea.config;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.ProjectJdk;
import com.intellij.openapi.roots.ProjectRootManager;
import org.ops4j.pax.runner.internal.RunnerOptionsImpl;
import org.ops4j.pax.runner.repositories.BundleRef;
import java.util.List;

public class ConfigBean extends RunnerOptionsImpl
{
    private ProjectJdk m_jdk;
    private Project m_project;
    private OsgiRunConfiguration m_osgiRunConfiguration;
    private List<BundleRef> m_bundleRefs;

    public ConfigBean( Project project, OsgiRunConfiguration osgiRunConfiguration )
    {
        m_project = project;
        m_osgiRunConfiguration = osgiRunConfiguration;
    }

    public ProjectJdk getJdk()
    {
        if( m_jdk == null )
        {
            return ProjectRootManager.getInstance( m_project ).getProjectJdk();
        }
        return m_jdk;
    }

    public void setJdk( ProjectJdk jdk )
    {
        m_jdk = jdk;
    }

    public OsgiRunConfiguration getOsgiRunConfiguration()
    {
        return m_osgiRunConfiguration;
    }

    public Project getProject()
    {
        return m_project;
    }

    public void setBundleRefs( List<BundleRef> bundleRefs )
    {
        m_bundleRefs = bundleRefs;
    }

    public List<BundleRef> getBundleRefs()
    {
        return m_bundleRefs;
    }

    public void addBundleRef( BundleRef bundle )
    {
        m_bundleRefs.add( bundle );
    }
}