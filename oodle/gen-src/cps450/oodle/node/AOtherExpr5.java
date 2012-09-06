/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AOtherExpr5 extends PExpr5
{
    private PExpr6 _expr6_;

    public AOtherExpr5()
    {
        // Constructor
    }

    public AOtherExpr5(
        @SuppressWarnings("hiding") PExpr6 _expr6_)
    {
        // Constructor
        setExpr6(_expr6_);

    }

    @Override
    public Object clone()
    {
        return new AOtherExpr5(
            cloneNode(this._expr6_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOtherExpr5(this);
    }

    public PExpr6 getExpr6()
    {
        return this._expr6_;
    }

    public void setExpr6(PExpr6 node)
    {
        if(this._expr6_ != null)
        {
            this._expr6_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr6_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expr6_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expr6_ == child)
        {
            this._expr6_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expr6_ == oldChild)
        {
            setExpr6((PExpr6) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
